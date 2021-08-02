# Work in progress
Multi-module demo app that gets data from a Dota2 api.

# List to Detail screen
<img src="https://github.com/mitchtabian/Dota-Info/blob/master/art/demo1.gif" width="25%">

# Filtering
<img src="https://github.com/mitchtabian/Dota-Info/blob/master/art/demo2.gif" width="25%">

# Module Design

| Module name        | Type                 | Description                                                      |
| -------------      | -------------        | -------------                                                    |
| [app](/app/)                | Android Application  | MainActivity, BaseApplication, Theme, Hilt setup.                |
| [core](/core/)               | Java/Kotlin Library  | Core business models and classes.                                |
| [hero-datasource](/hero/hero-datasource/)    | Java/Kotlin Library  | Data-sources (network and cache) for the hero Module.            |
| [hero-datasource-test](/hero/hero-datasource-test/)    | Java/Kotlin Library  | Data-source test fakes. These are contained in their own module so they can be used in tests in other modules.            |
| [hero-domain  ](/hero/hero-domain/)        | Java/Kotlin Library  | Domain models and classes for the hero Module.                   |
| [hero-interactors ](/hero/hero-interactors/)   | Java/Kotlin Library  | Use-cases for the hero Module.                                   |
| [ui-heroList](/ui-heroList/)        | Android Library      | UI components for the HeroList screen.                           |
| [ui-heroDetail](/ui-heroDetail/)      | Android Library      | UI components for the HeroDetail screen.                         |
| [constants](/constants/)          | Java/Kotlin Library  | Random constants.                                                |
| [components](/components/)         | Android Library      | Common Composables.                                              |

# Architecture
<img src="/art/dotainfo_architecture.png" width="50%" height="50%" />


# Tests

### Unit Tests
I wrote unit tests for every use-case.
1. [GetHerosTest.kt](hero/hero-interactors/src/test/java/com/codingwithmitch/dotainfo/hero_interactors/GetHerosTest.kt)
1. [GetHeroFromCacheTest.kt](hero/hero-interactors/src/test/java/com/codingwithmitch/dotainfo/hero_interactors/GetHeroFromCacheTest.kt)
1. [FilterHerosTest.kt](hero/hero-interactors/src/test/java/com/codingwithmitch/dotainfo/hero_interactors/FilterHerosTest.kt)

### Compose UI Tests
[UI Tests](/app/src/androidTest/java/com/codingwithmitch/dotainfo/ui)

# build.gradle files
There are 3 types of build.gradle files.
1. android application (app module)
1. android-library-build.gradle
    - Android module that contains ui components.
1. library-build.gradle
    - Pure java/kotlin library.

# API
https://docs.opendota.com/

### Hero Stats (GET)
https://api.opendota.com/api/heroStats

# Known issues
1. [HeroListFilter.kt](ui-heroList/src/main/java/com/codingwithmitch/ui_herolist/components/HeroListFilter.kt)
    - Changing the filter does not rebuild the dialog with the correct size.

# Credits
1. [Hristijan](https://twitter.com/funky_muse)
    - Thanks for the chat and great [sample](https://github.com/FunkyMuse/Aurora).

















