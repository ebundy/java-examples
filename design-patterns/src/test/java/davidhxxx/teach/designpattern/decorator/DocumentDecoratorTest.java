package davidhxxx.teach.designpattern.decorator;

import org.junit.Test;

import davidhxxx.teach.designpattern.decorator.input.DocumentInput;
import davidhxxx.teach.designpattern.decorator.input.IDocumentInput;
import davidhxxx.teach.designpattern.decorator.input.SecuredDocumentInputDecorator;
import davidhxxx.teach.designpattern.decorator.input.TarCompressedDocumentInputDecorator;
import davidhxxx.teach.designpattern.decorator.input.ZipCompressedDocumentInputDecorator;
import davidhxxx.teach.designpattern.decorator.output.DocumentOutput;
import davidhxxx.teach.designpattern.decorator.output.IDocumentOutput;
import davidhxxx.teach.designpattern.decorator.output.SecuredDocumentOutputDecorator;
import davidhxxx.teach.designpattern.decorator.output.TarCompressedDocumentOutputDecorator;
import davidhxxx.teach.designpattern.decorator.output.ZipCompressedDocumentOutputDecorator;
import junit.framework.Assert;

public class DocumentDecoratorTest {

    private static final String MAGIC_HEADER_PKZIP = "PK";

    @Test
    public void documentWithNoDecorator() throws Exception {
	final String contentToWrite = "Hello, who is here ?";
	DocumentOutput document = new DocumentOutput(contentToWrite);

	// action
	document.writeInMemory();

	// assertion, we can retrieve the original doc
	final byte[] bytesDocumentTransformed = document.getBytes();
	DocumentInput documentInput = new DocumentInput(bytesDocumentTransformed);
	documentInput.read();
	String actualContent = documentInput.getStringContent();
	Assert.assertEquals(contentToWrite, actualContent);
    }

    @Test
    public void documentWithPkZipDecorator() throws Exception {
	final String contentToWrite = "Hello, who is here ?";
	DocumentOutput document = new DocumentOutput(contentToWrite);
	IDocumentOutput documentDecorator = new ZipCompressedDocumentOutputDecorator(document);
	// action
	documentDecorator.writeInMemory();

	// assertion
	final byte[] bytesDocumentTransformed = documentDecorator.getBytes();

	// assertion, we have zip
	assertIsPkZipped(bytesDocumentTransformed);
	// assertion, we can retrieve the original doc
	DocumentInput documentInput = new DocumentInput(bytesDocumentTransformed);
	IDocumentInput documentInputDecorator = new ZipCompressedDocumentInputDecorator(documentInput);
	documentInputDecorator.read();
	String actualContent = documentInputDecorator.getStringContent();
	Assert.assertEquals(contentToWrite, actualContent);
    }

    @Test
    public void documentWithPkZipPlusSecuredDecorators() throws Exception {

	final String contentToWrite = "Hello, who is here ?";
	DocumentOutput document = new DocumentOutput(contentToWrite);
	IDocumentOutput documentDecorator = new SecuredDocumentOutputDecorator(new ZipCompressedDocumentOutputDecorator(document));
	// action
	documentDecorator.writeInMemory();
	// assertion
	final byte[] bytesDocTransformed = documentDecorator.getBytes();
	DocumentInput documentInputTransformed = new DocumentInput(bytesDocTransformed);

	// assert file not seen as a zip and cannot be uncompressed
	assertIsNotSeenAsPkzipedAndcannotBeUncompressed(bytesDocTransformed, documentInputTransformed);

	// assert that we retrievethe original file by unsecuring, then unzipping

	// assert ok by decorating one after the oher
	final SecuredDocumentInputDecorator securedDocumentDecorator = new SecuredDocumentInputDecorator(documentInputTransformed);
	securedDocumentDecorator.read();
	byte[] bytesAfterUnsecurig = securedDocumentDecorator.getBytes();
	assertIsPkZipped(bytesAfterUnsecurig);
	IDocumentInput unzippedDocumentDecorator = new ZipCompressedDocumentInputDecorator(new DocumentInput(bytesAfterUnsecurig));
	unzippedDocumentDecorator.read();
	String actualContent = unzippedDocumentDecorator.getStringContent();
	Assert.assertEquals(contentToWrite, actualContent);

	// assert ok by doing a decorator chaining
	IDocumentInput chainingDecorators = new ZipCompressedDocumentInputDecorator(new SecuredDocumentInputDecorator(documentInputTransformed));
	chainingDecorators.read();
	actualContent = chainingDecorators.getStringContent();
	Assert.assertEquals(contentToWrite, actualContent);
    }

    @Test
    public void documentWithPkZipPlusTarPlusSecuredDecorators() throws Exception {

	final String contentToWrite = "Hello, who is here ?";
	DocumentOutput document = new DocumentOutput(contentToWrite);
	IDocumentOutput documentDecorator = new SecuredDocumentOutputDecorator(new ZipCompressedDocumentOutputDecorator(new TarCompressedDocumentOutputDecorator(document)));
	// action
	documentDecorator.writeInMemory();
	// assertion
	DocumentInput documentInput = new DocumentInput(documentDecorator.getBytes());
	IDocumentInput documentInputDecorator = new TarCompressedDocumentInputDecorator(new ZipCompressedDocumentInputDecorator(new SecuredDocumentInputDecorator(documentInput)));
	documentInputDecorator.read();
	String actualContent = documentInputDecorator.getStringContent();
	Assert.assertEquals(contentToWrite, actualContent);
    }

    private String readTwoFirstBytes(final byte[] bytesDocumentTransformed) {
	byte[] twoFirstBytes = new byte[2];
	twoFirstBytes[0] = bytesDocumentTransformed[0];
	twoFirstBytes[1] = bytesDocumentTransformed[1];

	String twoFirstChar = new String(twoFirstBytes);
	return twoFirstChar;
    }

    private void assertIsPkZipped(final byte[] bytesDocumentTransformed) {
	final String twoFirstBytes = readTwoFirstBytes(bytesDocumentTransformed);
	Assert.assertEquals(MAGIC_HEADER_PKZIP, twoFirstBytes);
    }

    private void assertIsNotSeenAsPkzipedAndcannotBeUncompressed(final byte[] bytesDocTransformed, DocumentInput documentInputTransformed) {
	String twoFirstBytes = readTwoFirstBytes(bytesDocTransformed);
	Assert.assertTrue("must not seen as a zip since secured", !twoFirstBytes.equals(MAGIC_HEADER_PKZIP));
	boolean isErrorWhenUnZip = false;
	IDocumentInput decoratorUncompressingButSecuringAgainPresents = new ZipCompressedDocumentInputDecorator(documentInputTransformed);
	try {
	    decoratorUncompressingButSecuringAgainPresents.read();
	}
	catch (IllegalArgumentException e) {
	    isErrorWhenUnZip = true;
	}
	Assert.assertTrue("error is expected when unziping", isErrorWhenUnZip);
    }

}
