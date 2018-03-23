# Quality assurance (code)

## Basics
1. Branch structure: ``master`` ist only used for releases and milestone commits. ``dev`` is used for shared development, but not pushed to directly. Feature branches are used to make code/repo changes. Then later a merge-request on gitlab is used to integrate the changes into the parent branch.
2. Merge request is assigned to other team member for sanity check.
3. Unit tests for java code with JUnit.
4. [Google CodeStyle](https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml) with check task via gradle and in IntelliJ.
5. Continuous integration via gitlab.

## Merge requirements

| Branch          |                                       |
|:----------------|---------------------------------------|
| ``master``    : | Checkstyle ✔️, UnitTest ✔️, Build ✔️     |
| ``dev``       : | Checkstyle ✔️, UnitTest ✔️, Build ⭕   |
| ``ft-branch`` : | Checkstyle ✔, UnitTest ⭕, Build ⭕ |


## Build process
//TODOS


## Javadocs
//TODOS


## UML diagrams
//TODOS