package davidhxxx.teach.designpattern.decorator.output;

public abstract class AbstractDocumentOutputDecorator implements IDocumentOutput {

    protected IDocumentOutput document;

    protected byte[] bytes;

    public AbstractDocumentOutputDecorator(IDocumentOutput document) {
	this.document = document;
    }

    public byte[] getBytes() {
	return bytes;
    }

}
