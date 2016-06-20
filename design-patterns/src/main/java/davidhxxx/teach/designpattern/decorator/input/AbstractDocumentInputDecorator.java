package davidhxxx.teach.designpattern.decorator.input;

import java.nio.charset.StandardCharsets;

public abstract class AbstractDocumentInputDecorator implements IDocumentInput {

    protected IDocumentInput document;
    protected byte[] bytes;

    public AbstractDocumentInputDecorator(IDocumentInput document) {
	this.document = document;
    }

    public byte[] getBytes() {
	return bytes;
    }

    public final String getStringContent() {
	return new String(getBytes(),StandardCharsets.UTF_8);
    }
}
