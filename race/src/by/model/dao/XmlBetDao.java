package by.model.dao;

import by.model.entity.Bet;
import by.model.entity.BetType;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class XmlBetDao implements BetDao {

    private final String filepath = "D:\\5_сем\\ВТ\\race\\src\\Bets.xml";
    private final File xmlFile = new File(filepath);


    @Override
    public void addBet(Bet bet) throws DataSourceException {
        try {
            Document document = XmlDao.parseXmlFile(xmlFile);
            Node root = document.getFirstChild();
            Element newNode = createBetNode(bet, document);
            root.appendChild(newNode);
            XmlDao.saveXmlFile(document, filepath);
        } catch (SAXException | IOException | ParserConfigurationException | TransformerException ex) {
            throw new DataSourceException("File " + xmlFile.getName() + " not found or is incorrect.");
        }
    }

    @Override
    public void updateBet(int id, Bet bet) throws DataSourceException, NotFoundException {
        try {
            Bet oldBet = getById(id);

            Document document = XmlDao.parseXmlFile(xmlFile);
            Node root = document.getFirstChild();
            NodeList betNodes = document.getDocumentElement().getElementsByTagName("Bet");
            Node oldNode = null;
            for (int i = 0; i < betNodes.getLength(); i++)
                if (Integer.parseInt(betNodes.item(i).getAttributes().getNamedItem("id").getNodeValue()) == id)
                    oldNode = betNodes.item(i);
            Element newNode = createBetNode(bet, document);
            newNode.setAttribute("id", String.valueOf(oldBet.getId()));
            root.replaceChild(newNode, oldNode);

            XmlDao.saveXmlFile(document, filepath);
            System.out.println("bet updated");
        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e) {
            throw new DataSourceException("File " + xmlFile.getName() + " not found or is incorrect.");
        }
    }

    @Override
    public void deleteBet(int id) throws DataSourceException {
        try {
            Document document = XmlDao.parseXmlFile(xmlFile);
            NodeList betNodes = document.getDocumentElement().getElementsByTagName("Bet");
            for (int i = 0; i < betNodes.getLength(); i++) {
                if (Integer.parseInt(betNodes.item(i).getAttributes().getNamedItem("id").getNodeValue()) == id) {
                    betNodes.item(i).getParentNode().removeChild(betNodes.item(i));
                }
            }
            XmlDao.saveXmlFile(document, filepath);
            System.out.println("bet deleted");
        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e) {
            throw new DataSourceException("File " + xmlFile.getName() + " not found or is incorrect.");
        }
    }

    private Element createBetNode(Bet bet, Document document) {
        Element newNode = document.createElement("Bet");
        newNode.setAttribute("id", Integer.toString(bet.getId()));
        newNode.setAttribute("type", String.valueOf(bet.getBetType()));
        newNode.setAttribute("participantId", Integer.toString(bet.getParticipantId()));
        newNode.setAttribute("horseId", Integer.toString(bet.getHorseId()));
        newNode.setAttribute("money",  Double.toString(bet.getMoney()));
        newNode.setAttribute("coefficient", Double.toString(bet.getCoefficient()));
        newNode.setAttribute("winMoney",Double.toString(bet.getWinMoney()));
        newNode.setAttribute("isWin", Boolean.toString(bet.isWin()));
        return newNode;
    }

    @Override
    public ArrayList<Bet> getBets() throws DataSourceException {
        ArrayList<Bet> betsList = new ArrayList<>();
        try {
            Document document = XmlDao.parseXmlFile(xmlFile);
            NodeList betNodes = document.getDocumentElement().getElementsByTagName("Bet");
            for (int i = 0; i < betNodes.getLength(); i++) {
                betsList.add(getBetFromNode(betNodes.item(i)));
            }
            System.out.println("finished");
        } catch (SAXException | IOException | ParserConfigurationException | ParseException e) {
            throw new DataSourceException("File " + xmlFile.getName() + " not found or is incorrect.");
        }
        return betsList;
    }

    @Override
    public ArrayList<Bet> getByParticipant(int participantId) throws DataSourceException {
        ArrayList<Bet> bets = getBets();
        ArrayList<Bet> result = new ArrayList<>();
        for (Bet bet: bets) {
            if (bet.getParticipantId() == participantId) {
                result.add(bet);
            }
        }
        return bets;
    }

    private Bet getBetFromNode(Node betNode) throws ParseException {
        Bet bet = new Bet();
        NamedNodeMap attributes = betNode.getAttributes();
        bet.setId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
        bet.setBetType(BetType.valueOf(attributes.getNamedItem("type").getNodeValue()));
        bet.setParticipantId(Integer.parseInt(attributes.getNamedItem("participantId").getNodeValue()));
        bet.setHorseId(Integer.parseInt(attributes.getNamedItem("horseId").getNodeValue()));
        bet.setMoney(Double.parseDouble(attributes.getNamedItem("money").getNodeValue()));
        bet.setCoefficient(Double.parseDouble(attributes.getNamedItem("coefficient").getNodeValue()));
        bet.setWinMoney(Double.parseDouble(attributes.getNamedItem("winMoney").getNodeValue()));
        bet.setWin(Boolean.parseBoolean(attributes.getNamedItem("isWin").getNodeValue()));
        return bet;
    }

    public Bet getById(int id) throws DataSourceException, NotFoundException {
        ArrayList<Bet> bets = getBets();
        for (Bet bet : bets) {
            if (bet.getId() == id) {

                return bet;
            }
        }
        throw new NotFoundException("Bet " + id + " not found");
    }


}
