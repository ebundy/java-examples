package davidhxxx.teach.designpattern.decorator.input;

import java.nio.charset.StandardCharsets;

public class DocumentInput implements IDocumentInput {

	private String content;
	private byte[] bytes;

	public DocumentInput(byte[] bytes) {
		this.bytes = bytes;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void read() {
	}

	public final String getStringContent() {
		if (content == null) {
			content = new String(getBytes(), StandardCharsets.UTF_8);
		}
		return content;
	}

}
