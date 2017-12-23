package davidhxxx.teach.designpattern.decorator.output;

import java.nio.charset.StandardCharsets;

public class DocumentOutput implements IDocumentOutput {

	private String content;
	private byte[] bytes;

	public DocumentOutput(String content) {
		this.content = content;
	}

	public void writeInMemory() {
		bytes = content.getBytes(StandardCharsets.UTF_8);
	}

	public byte[] getBytes() {
		return bytes;
	}

}
