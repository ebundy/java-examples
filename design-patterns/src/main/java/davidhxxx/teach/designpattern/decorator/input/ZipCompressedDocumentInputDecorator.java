package davidhxxx.teach.designpattern.decorator.input;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.utils.IOUtils;

public class ZipCompressedDocumentInputDecorator extends AbstractDocumentInputDecorator {

    public ZipCompressedDocumentInputDecorator(IDocumentInput document) {
	super(document);
    }

    public void read() {
	document.read();
	processUncompressing();
    }

    private void processUncompressing() {
	try {

	    final ByteArrayInputStream is = new ByteArrayInputStream(document.getBytes());
	    ArchiveInputStream archiveInput = new ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.ZIP, is);

	    ArchiveEntry nextEntry = archiveInput.getNextEntry();
	    if (nextEntry == null) {
		throw new IllegalArgumentException("not entry in the document input provided");
	    }
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    IOUtils.copy(archiveInput, byteArrayOutputStream);
	    byteArrayOutputStream.close();
	    archiveInput.close();
	    is.close();
	    this.bytes = byteArrayOutputStream.toByteArray();
	}

	catch (IllegalArgumentException e) {
	    throw e;
	}
	catch (Exception e) {
	    throw new RuntimeException(e);
	}

    }

}
