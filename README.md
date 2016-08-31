# grails-gorm-ja_nein_type
transforms a db character field with 'J' and 'N' values to a grails-domain-class field of type boolean
(More or less a german representation of the 'yes_no' type.)

true = 'J',

false = 'N'

**Using:**

```
package myPackage

class MyClass implements Serializable {
	
	boolean finished
	
	static mapping = {
		finished type: JaNeinType
  }
}
```
