# Liga_Classement_Springboot

Informations complémentaire Projet Java : 

Ayant fini mon back end, j’ai voulu me lancer dans le front. Par contre, je n’avais pas beaucoup de temps, du coup dans mon front end,
j’ai juste affiché dans différentes pages les données (les méthodes GET) c’est tout.
Mais comme mon code contient la sécurité. Dans la méthode « WebSecurityConfiguration », j’ai laissé l’accès aux URL des méthodes GET : 
         "/teams",
         "/trainers",
         "/players",
         "/leagues",
         "/"
                  
Du coup on peut accéder à mon site à cette URL : http://localhost:8090/ (en lançant XAMPP bien sûr). 

Mais j’ai implémenté une méthode pour la sécurité de mon front end qui fait que le login donc elle n’est pas complètement finie. 
Mais si vous voulez tester il faut décommenter le code de la ligne 64 à 79. 
Et mettre en commentaire le code de la ligne 51 à 62. 
Tous les deux de la classe "WebSecurityConfiguration".
Et du coup, lorsqu’on voudra arriver sur un lien cela nous redirigera vers une page login qui nous ouvrira l’accès aux méthodes. Et nous pourrons nous Logout sur la page Logout. 


Mais, tout est accessible sur swagger, les user, les différentes méthodes etc. Le front était juste un plus. 
L’URL du swagger est : http://localhost:8090/swagger-ui/
