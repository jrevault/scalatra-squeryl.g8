scalatra-squeryl.g8
===================

A giter8(https://github.com/n8han/giter8) template that creates a sbt(https://github.com/harrah/xsbt/wiki/) project for scalatra(https://github.com/scalatra/scalatra) and squeryl(https://github.com/max-l/Squeryl)
Based on sbt 0.11.2 it includes :
* eclipse plugin
* idea plugin
* proguard
* several JDBC drivers (mysql, postres, h2, jtds, derby)
* sbt assembly
* jerkson
* joda-time
* specs2

Usage
===================
Open a console and :

    $ g8 jrevault/scalatra-squeryl.g8

The '.g8' suffix is implicit:

    $ g8 jrevault/scalatra-squeryl

You will now be prompted for each parameters... I know there are a lot, and they aren't logically ordered (I don't know why) :7

Once everything is ok (you can leave everything by default) :
    
    $ cd <your newly created folder>
    
    $ sbt
    
    $ container start
    
Then just open a navigator and go there http://localhost:8080(http://localhost:8080) and you'll have frther instructions.

Have a nice day !