-- Create a new user, grant her rights, and set her password.
grant select, insert, update, delete
on lfycore.*
to lfycore@localhost identified by 'root';