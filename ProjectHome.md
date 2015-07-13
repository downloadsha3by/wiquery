![http://wiquery.googlecode.com/files/wiquery.png](http://wiquery.googlecode.com/files/wiquery.png)

# wiQuery - Wicket / jQuery integration #

wiQuery aims to bind **jQuery** and **jQuery UI** within the **Java** **Wicket** framework, a Java framework providing a real way to create web applications with an OO approach.

## **Our code has moved to GitHub : https://github.com/WiQuery/wiquery** ##

## **Our Google Groups mailinglist has been deleted! Please use the issue tracker here, or email to the Wicket mailinglist! We do read your posts!** ##

Check the following items to get more:
  * Last stable version: 6.9.1 at maven central.
  * Last development version: 6.8.0-SNAPSHOT https://oss.sonatype.org/content/groups/public/org/odlabs/wiquery/
  * Documentation home: http://code.google.com/p/wiquery/wiki/DocumentationHome
  * Checkout some resources about the project (screencasts etc.) on the [Resources](Resources.md) page
  * Checkout the sources of our "scrum dashboard" demo we've made for the London Weekend Event organized by jWeekend: http://wiquery.googlecode.com/svn/examples/wiquery-presentation-examples.


---




---

# Release 6.9.1 (23-07-2013) #
Compiled against Wicket 6.9.1. This contains a JQuery UI update because Wicket updated their provided JQuery version.

# Release 6.6.0 (26-02-2013) #
Compiled against Wicket 6.6.0 and fixed an unit test.

# Release 6.5.0 (18-02-2013) #
Compiled against Wicket 6.5.0

# Release 6.0.0 (28-08-2012) #
Compiled against Wicket 6.0.0. We from WiQuery are happy to announce the release of WiQuery 6.0.0!

Unlike WiQuery 1.5 this release has become smaller. All of the resource management present in WiQuery 1.5 has been removed because Wickets resource management has been totally revamped and works nearly the same. This considerably decreases the footprint of WiQuery. Not only in LOC but also in performance. This allows us to start focusing completely on providing users with a JQuery statement API and JQuery UI components.

For backward compatibility purposes some of the 1.5 API has been marked deprecated instead of removing it completely. For example: all Behaviors in WiQuery will check if the statement() function is still used and if so use the new approach to render.

Our artifacts can be found at maven central. See listing here: http://mvnrepository.com/artifact/org.odlabs.wiquery/
Checkout the [Wicket](https://cwiki.apache.org/WICKET/migration-to-wicket-60.html) migration guide and [our](http://code.google.com/p/wiquery/wiki/Migration60) migration guide to see how to migrate.

# Release 1.5.7 (18-06-2012) #
Compiled against Wicket 1.5.7

# Release 1.5.6 (22-05-2012) #
Compiled against Wicket 1.5.6, fixed 6 bugs: http://code.google.com/p/wiquery/issues/list?can=1&q=milestone%3DRelease1.5.6.

Starting this version we release all our versions via the sonatype repository, to maven central. Snapshots are not released to maven central, you will have to add the sonatype snapshot repo to your maven settings:
https://oss.sonatype.org/content/repositories/snapshots

# Release 1.5.5 (29-03-2012) #
Compiled against Wicket 1.5.5, fixed 6 bugs: http://code.google.com/p/wiquery/issues/list?can=1&q=milestone%3DRelease1.5.5.

# Release 1.5.4 (13-02-2012) #
Compiled against Wicket 1.5.4, fixed 10 bugs: http://code.google.com/p/wiquery/issues/list?can=1&q=milestone%3DRelease1.5.4.

# Release 1.5.3 (14-11-2011) #
Compiled against Wicket 1.5.3, added 2 checks to prevent NullPointerExceptions :) and check if the RequestHandler is a RequestHandlerDelegate.

# Release 1.5.2 #
Compiled against Wicket 1.5.2, no real changes.

# Release 1.5.1 #
Fixes a lot of internal problems with Wicket and the rendering of resources/plain scripts in ajax requests. Please update to this version ASAP.

---
# Release 1.5.0 !! #
After weeks of debugging, testing and collaboration with users we have released WiQuery 1.5.0!

A lot has changed in WiQuery, most things invisible for end users. Here is a list of features of WiQuery (old and new):
  * Components or Behaviours implementing the interface IWiQueryPlugin can define a jQuery statement which is gathered at the end of each requestcycle and send to the client to be executed on dom document ready. The jQuery JavaScript resource is automatically added for you.
  * Components or Behaviours can now use the wicket function renderHead() instead of Wiquery's contribute() to render ResourceReferences or plain scripts to the HeaderResponse.
  * ResourceReferences can have their dependencies defined so that end users do not have to add a long list of ResourceReferences but only 1 (or in worst case a few).
  * ResourceReferences are rendered in a predefined sorted order (first wicket, then wiquery, then the rest) so that every resource has its dependencies loaded before itself. This can be configured to be different.
  * WiQuery provides 2 YUI Compressors, one for JS and one for CSS, which have to be set manually. They compress your JavaScript or StyleSheet on the fly. Note that this increases server render time.
  * WiQuery is split in 2 artifacts: wiquery-core and wiquery-jquery-ui. When using wiquery-jquery-ui Components or Behaviors which have the @WiQueryUIPlugin annotation automatically get the jQuery UI theme ResourceReferences added.
  * Some API changes were necessary, this means you project will not compile but most errors are the same:
    * Most Wiquery ResourceReferences were renamed to reflect Wicket's ResourceReferences name change from Javascript to JavaScript.
    * The contribute() function is no longer present in IWiQueryPlugin, this can be done by using the Component.renderHead() or Behavior.

In order to use WiQuery you need to add one of the artifacts below (wiquery-core contains no jquery ui, wiquery-jquery-ui contains a subset of jquery default components):

```
<dependency>
	<groupId>org.odlabs.wiquery</groupId>
	<artifactId>wiquery-core</artifactId>
	<version>1.5.0</version>
</dependency>

<dependency>
	<groupId>org.odlabs.wiquery</groupId>
	<artifactId>wiquery-jquery-ui</artifactId>
	<version>1.5.0</version>
</dependency>
```

We are working on updating our Wiki during the coming week. Here you will find more information about current and new classes and how to use them.


# Release 1.5-RC4 #
The third release candidate fixed some bugs, but introduced 2 more :) That's why we released RC4 today. Here is a list of fixed issues:
  * WiQuery behaviors of non-WiQuery components were never rendered.
  * Components which did not have setOutputMarkupId set to true manually were never refreshed in Ajax requests. With WiQuery 1.2.x this was done automatically by WiQuery and now since RC4 this is done by WiQuery again.
  * bug fixes: #174, #205, #207, #208


# Release 1.5-RC2 #
The second release candidate of WiQuery for Wicket-1.5.0 is out! This version upgrades jQuery to 1.6.3 and jQuery UI to 1.8.16.

# Release 1.5-RC1.1 #

The first release candidate of WiQuery for Wicket-1.5 is out.
Note that there is a WiQuery 1.5-RC1 however this contains a bug which has been fixed in RC1.1

This RC contains a total rewrite of the resource management.
  * All Wiquery resource references have their dependencies hard coded so that all resources are loaded in the correct order.
  * Resource merging is no longer supported, the system was too buggy and often resulted in inefficient huge resources. We believe this is a job for Wicket, as Wicket can merge all resources not just Wiquery resources.
  * Upgraded to jQuery 1.6.2 and jQuery UI 1.8.16.
  * Some classes have been renamed or better Capitalized to better reflect their purpose.
  * bug fixes: #134, #94


  * **Note: The function of IWiQueryPlugin called contribute(WiQueryResourceManager) is removed and you need to use the Component#renderHead(HeaderResponse) to add resources.
  * As always no additional configuration is required to use WiQuery, you only have to add the jar(s) to your projects classpath.**

# Release 1.5-M3 #

The third milestone of wiQuery for Wicket-1.5-RC5.1 is out.
This milestone contains only changes to work with Wicket 1.5-RC5.1 and some bugfixes.

# Release 1.2.4 #

A lot of internal changes (new YUI) and a few API changes.
  * Datepicker language resource api changed, can now return null!
  * latest jquery and jquery-ui.
  * update to wicket 1.4.17
  * bug fixes: #166, #160, #178, #179
  * improved mavne configuration

# Release 1.5-M2 #

The second milestone of wiQuery for Wicket-1.5-RC4.2 is out. We are nearing completion!

Please note that when using maven2 you need to change the artifact! Either use **wiquery-core** (contains no wiquery ui components) or **wiquery-jquery-ui** (contains wiquery ui components and pulls **wiquery-core**) as artifactId.

# Release 1.5-M1 #

The first milestone of wiQuery for Wicket-1.5.

# Release 1.2.3 #

Move to jQuery 1.5.1 and jQuery UI 1.8.10

Fixes the following issues (bugfixes and enhancements):
  * [issue 161](https://code.google.com/p/wiquery/issues/detail?id=161)
  * [issue 153](https://code.google.com/p/wiquery/issues/detail?id=153)
  * [issue 160](https://code.google.com/p/wiquery/issues/detail?id=160)
  * [issue 159](https://code.google.com/p/wiquery/issues/detail?id=159)
  * a fix on the dialog (for the button style)
  * little enhancements

Many thanks to Hielke Hoeve


![http://wiquery.googlecode.com/files/logo-odlabs_seul-2.png](http://wiquery.googlecode.com/files/logo-odlabs_seul-2.png) http://wiquery.googlecode.com/files/jWeekendLogo.PNG

Sponsored by [jWeekend](http://www.jWeekend.com/) and [odlabs](http://www.objetdirect.com/html/espacetechno/odlabs.html) (an inovation label by [ObjetDirect](http://www.objetdirect.com))