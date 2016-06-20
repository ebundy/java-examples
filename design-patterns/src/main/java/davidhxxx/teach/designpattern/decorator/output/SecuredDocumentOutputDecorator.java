package davidhxxx.teach.designpattern.decorator.output;

import org.apache.commons.codec.binary.Base64;

public class SecuredDocumentOutputDecorator extends AbstractDocumentOutputDecorator {


    public SecuredDocumentOutputDecorator(IDocumentOutput document) {
	super(document);
    }

    public void writeInMemory() {
	document.writeInMemory();
	processSecurizing();
    }

    private void processSecurizing() {
	byte[] originalBytes = document.getBytes();
	bytes = Base64.encodeBase64(originalBytes);
    }



}
