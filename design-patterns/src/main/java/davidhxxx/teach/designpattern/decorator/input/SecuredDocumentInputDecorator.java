package davidhxxx.teach.designpattern.decorator.input;

import org.apache.commons.codec.binary.Base64;

public class SecuredDocumentInputDecorator extends AbstractDocumentInputDecorator {

    public SecuredDocumentInputDecorator(IDocumentInput document) {
	super(document);
    }

    @Override
    public void read() {
	document.read();
	processUnsecuring();
    }

    private void processUnsecuring() {
	byte[] originalBytes = document.getBytes();
	bytes = Base64.decodeBase64(originalBytes);
    }

}
