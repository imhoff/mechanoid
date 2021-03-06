Getting Started
===============
If you are familiar with the Android SDK then getting up and running with
Mechanoid should be quite straight forward.

This topic will guide you through the process of installing Mechanoid and
setting it up for an Android Project.

Prerequisites
-------------
The following points outline the requirements of Mechanoid.

* The plugin is developed and tested with Eclipse Juno and has not been tested with previous versions.
* The Mechanoid generated source code requires the Mechanoid Library Jar which is compatible with Android API Level 8 and upwards.
* The Mechanoid generated source requires the Android SDK and is only known to work with Android Projects and Android Library Projects.

Installation
------------
Mechanoid can be installed like other Eclipse Plugins. In Eclipse go to Help > 
Install New Software and add the following update site URL.

**Latest Snapshot Release**: ``http://www.robotoworks.com/mechanoid/updates/snapshot``

.. warning:: If you have installed any previous alpha releases (versions ending with .alpha), its possible that you may not be able to install without first uninstalling the previous versions, this is due to a new build/release process.

Android Project Setup
---------------------
The following steps describe how to setup a project for Mechanoid:

.. rubric:: Step 1: Create Android Project

Create an Android Project with the Eclipse ADT Plugin

.. rubric:: Step 2: Put Mechanoid Runtime Library In Your Classpath

Copy the mechanoid.jar library to the libs folder of your Android project

**Latest Snapshot Release**: ``http://www.robotoworks.com/mechanoid/updates/snapshot/mechanoid.jar``

**Latest Snapshot Release (Source, Docs)**: ``http://www.robotoworks.com/mechanoid/updates/snapshot/mechanoid-sources.jar``

.. note:: If you have not added the library, Eclipse will show an error and provide a quickfix to add it, this provides the best compatibility because the library is bundled with the plugin

.. warning:: 
   The Mechanoid Plugin requires the Mechanoid library (mechanoid.jar), if it 
   is not present or up-to-date compilation errors can occur if the generated 
   Mechanoid source code references classes/methods that do not exist in the 
   mechanoid.jar. Always make sure you have the latest version of the library – 
   when updating the plugin also update mechanoid library in your projects.

.. rubric:: Step 3: Initialize Mechanoid in your Application

For mechanoid to work it needs to be initialized, you do this by adding calling 
:java:extdoc:`Mechanoid.init(Context) <com.robotoworks.mechanoid.Mechanoid.init(android.content.Context)>` 
in a custom application class as follows:

.. code-block:: java

	public class MyApplication extends Application {
	 
	    @Override
	    public void onCreate() {
	        super.onCreate();
	 
	        Mechanoid.init(this);
	    }
	}

Then make sure your application class is registered in your manifest:

.. code-block:: xml

	<application android:name="MyApplication">
	

