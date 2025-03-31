# Gestionnaire de Tâches

Ce projet est une application web simple pour gérer vos tâches quotidiennes. Conçu avec soin en respectant les traditions du développement Java, il utilise **Spring Boot** pour la configuration et le déploiement, **Thymeleaf** pour le rendu des vues, **Spring Data JPA** pour la gestion de la persistance, et **H2** comme base de données en mémoire.

## Prérequis

- **Java 17** (ou version supérieure)
- **Maven 3.x**
- Un navigateur web moderne

## Installation

1. **Cloner le repository**

   ```bash
   git clone https://votre-url-de-repository.git
   ```

2. **Accéder au dossier du projet**

   ```bash
   cd dotolist
   ```

3. **Compiler et lancer l'application**

   ```bash
   mvn spring-boot:run
   ```

## Utilisation

- Une fois l'application lancée, ouvrez votre navigateur et rendez-vous sur : [http://localhost:8080/tasks](http://localhost:8080/tasks)

- Vous pouvez :

  - **Ajouter** une nouvelle tâche.
  - **Supprimer** une tâche existante.
  - **Marquer** une tâche comme complétée ou la remettre en cours via un simple clic.

- Pour accéder à la console de la base de données H2, rendez-vous sur : [http://localhost:8080/h2-console](http://localhost:8080/h2-console)\
  Les informations de connexion se trouvent dans le fichier `application.properties`.

## Structure du projet

- **pom.xml**\
  Configuration Maven et gestion des dépendances (Spring Boot, Thymeleaf, Spring Data JPA, H2).

- **src/main/java/org/example**

  - `Main.java` : Point d'entrée pour afficher un message simple ("Hello, World!") dans la console.
  - `TodoListApplication.java` : Classe principale qui lance l'application Spring Boot.

- **src/main/java/org/example/controller**

  - `TaskController.java` : Contrôleur gérant les requêtes liées aux tâches (affichage, ajout, suppression, basculement de l'état).

- **src/main/java/org/example/model**

  - `Task.java` : Entité représentant une tâche avec sa description, son état (complétée ou non) et la date de création.

- **src/main/java/org/example/repository**

  - `TaskRepository.java` : Interface étendant `JpaRepository` pour faciliter les opérations CRUD sur les tâches.

- **src/main/resources**

  - `application.properties` : Fichier de configuration pour la base de données, JPA, Thymeleaf et autres paramètres.
  - `templates/tasks.html` : Template Thymeleaf pour l'interface utilisateur, enrichi de Bootstrap pour une mise en forme moderne et conviviale.

## Points importants

- **Spring Boot** simplifie le déploiement et la configuration de l’application.
- **Thymeleaf** permet la génération dynamique de pages HTML.
- **Spring Data JPA** facilite l'interaction avec la base de données, en particulier avec H2 qui est idéale pour le développement et les tests.
- **Bootstrap** est intégré pour offrir une interface utilisateur élégante et réactive.



## Fonctionnalités à implémenter ultérieurement

- **Authentification utilisateur** : permettre aux utilisateurs de créer un compte et gérer leurs propres tâches.
- **Notifications par e-mail** : informer les utilisateurs des tâches à venir ou des tâches en retard.
- **Gestion avancée des tâches** : définir des priorités, des dates d'échéance, et des rappels.
- **Intégration d'une base de données externe** : par exemple MySQL ou PostgreSQL, pour une meilleure persistance des données.
- **Historique des tâches** : conserver l'historique des tâches terminées pour un meilleur suivi.
- **API RESTful** : fournir une interface API pour permettre l'intégration avec d'autres services ou applications.



