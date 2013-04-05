Panopto-Java-FolderCreator
==========================

A quick, dirty and very simple way of adding a folder to Panopto. This would also allow you to batch add folders by grouping calls to the jar in a batch or shell script.

Libraries required to compile
-----------------------------

* Apache AXIS... we used version 1.6.2
* [Panopto-Java-Util](https://github.com/andmar8/Panopto-Java-Util) Library

How to use the jar
------------------

<pre>
java -jar PanoptoFolderCreator (Server) (Username) (Password) (FolderName)
</pre>

For example...

<pre>
java -jar PanoptoFolderCreator panoptoserver.example.com admin password Q1213-COM1001
</pre>

Slight nuance
-------------

In our testing we noticed a strange nuance, when you create a folder the API call is succesfully sent and the folder "is" being create**d** but often isn't **visible** in the Panopto GUI for a short period of time (seconds), but a lot longer than you would expect for such a seemingly simple API call(???)