mysql> show tables;
+-----------------+
| Tables_in_trial |
+-----------------+
| admin           |
| customer        |
| product         |
| transaction     |
| updates         |
+-----------------+
5 rows in set (0.02 sec)

mysql> desc admin;
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| Admin_id | int         | NO   | PRI | NULL    |       |
| Username | varchar(30) | NO   |     | NULL    |       |
| Password | varchar(15) | NO   |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> desc customer;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| roll_number  | varchar(10)  | NO   | PRI | NULL    |       |
| Student_name | varchar(255) | YES  |     | NULL    |       |
| phno         | varchar(10)  | YES  |     | NULL    |       |
| department   | varchar(255) | YES  |     | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

mysql> desc product;
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| P_Id     | int         | NO   | PRI | NULL    |       |
| P_Name   | varchar(50) | NO   |     | NULL    |       |
| Price    | int         | NO   |     | NULL    |       |
| Category | varchar(50) | NO   |     | NULL    |       |
| Quantity | int         | NO   |     | NULL    |       |
| Admin_id | int         | YES  | MUL | NULL    |       |
+----------+-------------+------+-----+---------+-------+
6 rows in set (0.00 sec)

mysql> desc transaction;
+-------------+---------------+------+-----+---------+----------------+
| Field       | Type          | Null | Key | Default | Extra          |
+-------------+---------------+------+-----+---------+----------------+
| t_id        | int           | NO   | PRI | NULL    | auto_increment |
| P_Id        | int           | NO   |     | NULL    |                |
| P_name      | varchar(50)   | NO   |     | NULL    |                |
| quantity    | int           | NO   |     | NULL    |                |
| time_date   | date          | NO   |     | NULL    |                |
| custId      | varchar(10)   | YES  | MUL | NULL    |                |
| Total_Price | decimal(10,2) | YES  |     | NULL    |                |
| roll_number | varchar(10)   | YES  |     | NULL    |                |
+-------------+---------------+------+-----+---------+----------------+
8 rows in set (0.00 sec)

mysql> desc updates;
+--------+------+------+-----+---------+-------+
| Field  | Type | Null | Key | Default | Extra |
+--------+------+------+-----+---------+-------+
| P_Id   | int  | YES  | MUL | NULL    |       |
| custId | int  | YES  | MUL | NULL    |       |
+--------+------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql>
TABLES IN MYSQL
THIS IS A INCENTORY MANAGMENT SYSTEM USING MYSQL,JAVA,JAVA SWING,JDBC
