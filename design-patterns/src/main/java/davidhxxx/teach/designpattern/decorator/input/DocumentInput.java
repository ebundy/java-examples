package davidhxxx.teach.designpattern.decorator.input;

import java.nio.charset.StandardCharsets;

public class DocumentInput implements IDocumentInput {

    private byte[] bytes;

    public DocumentInput(byte[] bytes) {
	this.bytes = bytes;
    }

    public byte[] getBytes() {
	return bytes;
    }

    public void read() {
    }

    public String getStringContent() {
	return new String(getBytes(),StandardCharsets.UTF_8);
    }

}
