package be.abd.helbdemo.service;

import be.abd.helbdemo.Model.League;
import be.abd.helbdemo.dao.LeagueDAO;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LeagueServiceTest {

    private LeagueDAO leagueDAO;

    private LeagueService leagueService;

    @Test
    public void testGetLigue(){

        List<League> leagueList = List.of(new League("Bundesliga", 20, 1), new League("Ligue 1", 20, 7));


        leagueDAO = EasyMock.mock(LeagueDAO.class);
        EasyMock.expect(leagueDAO.findAll()).andReturn(leagueList);
        /*ligueDAO.findAll();
        EasyMock.expectLastCall(); pour les methodes void qui en retournent rien*/

        leagueService = new LeagueService(leagueDAO);
        EasyMock.replay(leagueDAO);
        List<League> result = leagueService.getLeague();
        EasyMock.verify(leagueDAO);
        assertEquals(2, result.size());



    }
}
