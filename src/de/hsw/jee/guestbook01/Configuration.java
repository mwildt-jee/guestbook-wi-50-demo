package de.hsw.jee.guestbook01;

import javax.annotation.sql.DataSourceDefinition;

@DataSourceDefinition(
	className="org.h2.jdbcx.JdbcDataSource",
	url="jdbc:h2:tcp://localhost/~/guestbook-01;AUTO_SERVER=TRUE;MVCC=TRUE",
	user="sa",
	password="",
	name="java:app/guestbook-01/h2ds"
)
public class Configuration {

}
