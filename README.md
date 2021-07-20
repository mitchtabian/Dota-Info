# Work in progress
Multi-module demo app that gets data from dota2 api.

# App Design (Likely to change)

### Module 1 (app)
MainActivity, BaseApplication, Theme.

### Module 2 (core)
Core business models and classes.

### Module 3 (hero)
Contains 3 sub-modules:
1. hero-datasource
    - Contains the datasources (network and cache) for the hero Module.
1. hero-domain
    - domain models and classes for the hero Module.
1. hero-interactors
    - Use-cases for the hero Module.

### Module 4 (ui-heroList)
UI components for the HeroList screen.

### Module 5 (ui-heroDetail)
UI components for the HeroDetail screen.


# build.gradle files
There are 3 types of build.gradle files.
1. android-ui-build.gradle
    - Android module that contains ui components.
1. android-library-build.gradle
    - Android module that does not contain any ui components. (ex: SQL Delight driver must be in an android module)
1. library-build.gradle
    - Pure java/kotlin library.


# API
https://docs.opendota.com/

### Hero Stats (GET)
https://api.opendota.com/api/heroStats


# Credits
1. [Hristijan](https://twitter.com/funky_muse)
    - Thanks for the chat and great [sample](https://github.com/FunkyMuse/Aurora).

















