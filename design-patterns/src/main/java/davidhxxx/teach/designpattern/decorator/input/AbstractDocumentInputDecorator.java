package davidhxxx.teach.designpattern.decorator.input;

import java.nio.charset.StandardCharsets;

public abstract class AbstractDocumentInputDecorator implements IDocumentInput {

    protected IDocumentInput document;
    protected byte[] bytes;
    private String content;

    public AbstractDocumentInputDecorator(IDocumentInput document) {
	this.document = document;
    }

    public byte[] getBytes() {
	return bytes;
    }

    public final String getStringContent() {
	if (content == null) {
	    content = new String(getBytes(), StandardCharsets.UTF_8);
	}
	return content;
    }
}
