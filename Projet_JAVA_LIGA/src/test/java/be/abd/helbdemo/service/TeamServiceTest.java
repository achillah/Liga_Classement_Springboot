package be.abd.helbdemo.service;


import be.abd.helbdemo.Model.Team;
import be.abd.helbdemo.dao.TeamDAO;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamServiceTest {

    private TeamDAO teamDAO;
    private TeamService teamService;

    @Test
    public void testGetBestTeam(){
        // Créez une liste d'équipes de test avec des points différents
        List<Team> teamList = List.of(
                new Team( "Real Madrid", 27, 38, 89, "logo", 1, 1),
                new Team( "Fc Barcelone", 29, 38, 91, "logo", 1, 2),
                new Team( "Real Sociedad", 6, 33, 14, "logo", 1, 3));

        // Créez un mock de TeamDAO
        teamDAO = EasyMock.mock(TeamDAO.class);
        // Configurez votre mock de TeamDAO pour renvoyer la liste d'équipes de test
        EasyMock.expect(teamDAO.findAllByOrderByNbrPointsDesc()).andReturn(teamList);

        // Créez une instance de TeamService avec le mock de TeamDAO
        teamService = new TeamService(teamDAO);

        // Activez le mock
        EasyMock.replay(teamDAO);

        // Appelez la méthode à tester sur l'instance de TeamService
        Team result = teamService.getBestTeam();

        // Vérifiez que le mock a été appelé comme prévu
        EasyMock.verify(teamDAO);

        // Assurez-vous que le résultat est celui attendu
        assertEquals(teamList.get(0), result);
    }

    @Test
    public void testGetStrongestTeam(){
        // Créez une liste d'équipes de test avec des points différents
        List<Team> teamList = List.of(
                new Team( "Real Madrid", 27, 38, 89, "logo", 1, 1),
                new Team( "Fc Barcelone", 29, 38, 91, "logo", 1, 2),
                new Team( "Real Sociedad", 6, 33, 14, "logo", 1, 3));

        // Créez un mock de TeamDAO
        teamDAO = EasyMock.mock(TeamDAO.class);
        // Configurez votre mock de TeamDAO pour renvoyer la liste d'équipes de test
        EasyMock.expect(teamDAO.findAllByOrderByNbrButsDesc()).andReturn(teamList);

        // Créez une instance de TeamService avec le mock de TeamDAO
        teamService = new TeamService(teamDAO);

        // Activez le mock
        EasyMock.replay(teamDAO);

        // Appelez la méthode à tester sur l'instance de TeamService
        Team result = teamService.getStrongestTeam();

        // Vérifiez que le mock a été appelé comme prévu
        EasyMock.verify(teamDAO);

        // Assurez-vous que le résultat est celui attendu
        assertEquals(teamList.get(0), result);
    }

}
