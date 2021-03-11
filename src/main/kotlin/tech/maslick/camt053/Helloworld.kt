import net.tjeerd.camt053parser.model.BankToCustomerStatementV02
import net.tjeerd.camt053parser.model.Document
import net.tjeerd.camt053parser.model.GroupHeader42
import java.io.File
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller


fun main() {
    val document = Document()
    val statementV02 = BankToCustomerStatementV02()

    statementV02.grpHdr = GroupHeader42()
    document.bkToCstmrStmt = statementV02

    val file = File("helloworld.xml")
    val jaxbContext: JAXBContext = JAXBContext.newInstance(Document::class.java)

    val jaxbMarshaller = jaxbContext.createMarshaller()
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)

    jaxbMarshaller.marshal(document, file);
    jaxbMarshaller.marshal(document, System.out);

}