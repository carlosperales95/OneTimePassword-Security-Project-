CREATE DATABASE otpdb;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX 
           ON otpdb.*
           TO root@'%'
           IDENTIFIED BY '';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON otpdb.*
           TO root@localhost
           IDENTIFIED BY '';