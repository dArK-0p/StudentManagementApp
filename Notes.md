# Hibernate API.

## Introduction to JPA and Hibernate.

### What is ORM?
    Mapping java objects to database tables.

### Why use ORM?
- Eliminates boilerplate JDBC code.
- Automated transaction management.
- Portability across different databases.
- Reduces SQL dependency with HQL(Hibernate Query Language).

### JDBC vs JPA vs Hibernate.

- JDBC -> Direct database interaction using SQL.
- JPA -> API specification for ORM(used by Hibernate, EclipseLink, etc.).
- Hibernate -> Popular JPA implementation with advanced features.

## Hibernate Architecture and Workflow.

### Core Components.
- SessionFactory.
- Session.
- Transaction.
- Query and Criteria API.
- Hibernate Configuration.

#### SessionFactory.
- Creates Session.
- Manages Session.
- Manages Transactions.
- Heavy Object.
- Created once per application.

#### Session.
- Interacts with database.
- Light Object.
- Created per transaction.
- Manages database transactions.
- Manages persistence context.

#### Transaction.
- Manages database transactions.
- Manages commit and rollback.

#### Query and Criteria API.
- Fetch data efficiently.
- Execute complex queries.

#### Hibernate Configuration.
- Hibernate.cfg.xml.
- Hibernate Properties.

## Hibernate Lifecycle and Workflow.

- Step1: Load Hibernate Configuration.
- Step2: Create SessionFactory.
- Step3: Create Session.
- Step4: Create Transaction.
- Step5: Perform CRUD Operations.
- Step6: Commit Transaction.
- Step7: Close Session.