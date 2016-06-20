package davidhxxx.teach.designpattern.decorator.output;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;

public class ZipCompressedDocumentOutputDecorator extends AbstractDocumentOutputDecorator {

    public ZipCompressedDocumentOutputDecorator(IDocumentOutput document) {
	super(document);
    }


    public void writeInMemory() {
	document.writeInMemory();
	processCompressing();
    }

    private void processCompressing() {
	OutputStream outputFile;
	try {
	    final File tempFileForArchive = File.createTempFile("output", "zip");
	    outputFile = new FileOutputStream(tempFileForArchive);
	    ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, outputFile);
	    archive.putArchiveEntry(new ZipArchiveEntry("doc"));
	    byte[] bytesOriginal = document.getBytes();
	    ByteArrayInputStream inputStream = new ByteArrayInputStream(bytesOriginal);
            IOUtils.copy(inputStream, archive);
            archive.closeArchiveEntry();
            archive.finish();
            outputFile.close();
            FileInputStream fileInputStream = new FileInputStream(tempFileForArchive);
            bytes= IOUtils.toByteArray(fileInputStream);
	}
	catch (Exception e) {
	    throw new RuntimeException(e);
	}

    }

}
