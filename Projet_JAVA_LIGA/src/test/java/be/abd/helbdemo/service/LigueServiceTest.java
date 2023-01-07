package be.abd.helbdemo.service;

import be.abd.helbdemo.Model.Ligue;
import be.abd.helbdemo.dao.LigueDAO;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LigueServiceTest {

    private LigueDAO ligueDAO;

    private LigueService ligueService;

    @Test
    public void testGetLigue(){

        List<Ligue> ligueList = List.of(new Ligue("Bundesliga", 20, 1), new Ligue("Ligue 1", 20, 7));


        ligueDAO = EasyMock.mock(LigueDAO.class);
        EasyMock.expect(ligueDAO.findAll()).andReturn(ligueList);
        /*ligueDAO.findAll();
        EasyMock.expectLastCall(); pour les methodes void qui en retournent rien*/

        ligueService = new LigueService(ligueDAO);
        EasyMock.replay(ligueDAO);
        List<Ligue> result = ligueService.getLigue();
        EasyMock.verify(ligueDAO);
        assertEquals(2, result.size());



    }
}
