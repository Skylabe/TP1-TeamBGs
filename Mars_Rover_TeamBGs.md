Mars_Rover_TeamBGs

# TP Mars Rover - Team Bgs


## Groupe



- Florian **Prudhomme**
- Anthony **Lesenfans**
- Bastien **Reys**
- Gauvain **Bouvart**
- Maxim **Cadet**

## Présentation du projet

Le *Mars Rover Project* est un jeu donnant le contrôle d'un rover sur Mars.

Le but de ce jeu sera d'être le dernier en vie, en se servant du laser pour éliminer les autres joueurs. Un joueur touché une fois par un tir de laser meurt.

Le jeu génèrera en aléatoire les paramètres suivants :


- taille de la carte (petite 100x100, moyenne 300x300, grande 600x600)
- positions des obstacles sur la carte (15% du terrain doit etre constitué d'obstacles)
- positions des 50 joueurs
- portée du laser (courte 5, moyenne 30, infinie -> risque d'auto-destruction si le tir fait le tour de la planete)

Les joueurs pourront interagir avec le jeu à travers une interface web.
Celle-ci leur devra leur permettre de :

- connaitre leur position
- connaitre la position des obstacles et joueurs adverses dans un carré de 30x30 (par défaut) autour du joueur (radar)
- connaitre la portée du laser
- se déplacer
- tirer avec le laser
- savoir le statut de son personnage (mort ou vivant)
* * *

## Le système original
**Est-ce que les joueurs intéragiront en temps réel, ou au tour par tour et pourquoi ?**
Pour éviter tout conflits, les joueurs intéragirton au tour par tour. 

**Comment sera stocké l'état (toutes les données permettant de représenter le jeu) ?**

**Comment seront stockées les informations confidentielles des joueurs (emails, etc.)**

**Comment gérer plusieurs parties en même temps ?**

**Comment gérer plusieurs parties par joueurs en même temps ?**

**Que se passera-t-il si un serveur plante ? (considérer la machine / vm / conteneur éteint(e) et inaccessible)**
En cas de panne, le joueur sera redirigé vers une page d'erreur (Erreur 500). 

**Comment les joueurs s'authentifieront et sauvegardent leur progression ?**


**Comment gérer une charge imprévue ? (100x plus de joueurs que prévu par ex)**
Afin de ne pas saturer le serveur, une limite de connexion de 50 joueurs est fixée. Au-delà de ce nombre, le serveur reverra vers une page HTML demandant de réessayer de se connecter plus tard.

## Mise à jour du système 
**Comment faire pour éviter la coupure de service ?**


**Que faire des parties en cours ?**


**Comment changer l'API pour que les joueurs utilisant une vieille version du client web puissent toujours jouer ? (rétro-compatibilité)**


**Comment avertir les joueurs de la nouveauté une unique fois ?**

























