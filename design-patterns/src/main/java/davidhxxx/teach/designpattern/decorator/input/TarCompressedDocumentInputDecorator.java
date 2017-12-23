package davidhxxx.teach.designpattern.decorator.input;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.utils.IOUtils;

public class TarCompressedDocumentInputDecorator extends AbstractDocumentInputDecorator {

	public TarCompressedDocumentInputDecorator(IDocumentInput document) {
		super(document);
	}

	@Override
	public void read() {
		document.read();
		processUncompressing();
	}

	private void processUncompressing() {
		try {

			final ByteArrayInputStream is = new ByteArrayInputStream(document.getBytes());
			ArchiveInputStream archiveInput = new ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.TAR, is);

			archiveInput.getNextEntry();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			IOUtils.copy(archiveInput, byteArrayOutputStream);
			byteArrayOutputStream.close();
			archiveInput.close();
			is.close();
			this.bytes = byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
