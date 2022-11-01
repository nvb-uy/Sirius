# Sirius API
An API to make less repetitive cod, sync changes across all mods and easing the making of configs and addons.


Integrating Sirius API using CurseMaven in your gradle file:

```
repositories { 
  maven { 
    url "https://cursemaven.com" 
    content { includeGroup "curse.maven" } 
  } 
}
```

```
dependencies { 
  implementation fg.deobf("curse.maven:sirius-695681:{fileid}") 
}
```

You can get the fileid from the CurseForge's URL.
