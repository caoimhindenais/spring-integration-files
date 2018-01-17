# Spring integration files

Example of a tiny Spring Integration used to:
 
1. Read File from ${input.directory}
2. Persist the file to a postgress DB
3. Write the file to ${output.directory}

This application uses an accept once FileSystemPersistentAcceptOnceFileListFilter backed by a JDBC Metatdatastore to ensure multiple instances of this application 
can run in parallel and no instance will process a file already
processed by another. 
DDL is here  : _**`schema-postgresql.sql`**_

                <bean class="org.springframework.integration.file.filters.FileSystemPersistentAcceptOnceFileListFilter">
                    <constructor-arg index="0" ref="JDBCMetadataStore"/>
                    <constructor-arg index="1" value="files"/>
                </bean>
                
Note: Of course this comes a the cost of performance.
 
1. JMS listeners with a distributed transaction (XA) between the Queue and Database resource would be an order( orders?) of magnitute quicker

2. Kakfa consumers using no transactions (idempotent operations) would be
again orders of magnitude quicker.

File/Message size is one determining factor in which direction would go.
 