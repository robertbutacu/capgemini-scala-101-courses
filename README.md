# capgemini-scala-101-courses
Scala journey with exercises, explanations and links to blogposts and talks.

The agenda is composed of 6 weeks of individual trainings, with the purpose of talking about some of the inners of the Scala language and functional programming principles.

The lessons are:
  1. Scala and Sbt basics
      - val, var, def, lazy, trait, sealed, imports, functions, type inference
      - talk about imports
      - sbt talk - dependencies mainly
 
  2. Functional programming principles:
      - immutability 
      - pureness + referential transparency
      - functions + function composition
      - recursiveness 
      - talk about types - generics and relevance
      - why is this relevant? testing and correctness

  3. Scala standard library:
      - list, sets, option, either
      - functions - filter, map, flatMap, exists, contains, etc

  4. Functional composition through monads:
      - what functors and monads are and how they are relevant - their relationship with function composition
      - for-comprehensions
      - monadic design
      
  5. Implicits:
      - types of implicits
      - usefulness 
      - case study: Future[] flow
      - their scope
  
  6. Play framework:
      - overall architecture of an app
      - controllers -> services -> repositories. models
      - anatomy of an endpoint - from routes, to controller, and so on
      - anatomy of a controller function
      - keywords: @Inject() and others
      - connectors and their crucial importance in our platform architecture
