# DesignPatterns
Some of common design patterns implemented into Java

## Implemented patterns yet

### Creational patterns

- Factory
    - Define an interface for creating a single object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
- Prototype
  -	Specify the kinds of objects to create using a prototypical instance, and create new objects from the 'skeleton' of an existing object, thus boosting performance and keeping memory footprints to a minimum.
- Singleton
    - Ensure a class has only one instance, and provide a global point of access to it. 

### Structural patterns 

- Flyweight (looks doesn't work)
    - Use sharing to support large numbers of similar objects efficiently.
- Adapter
    - Convert the interface of a class into another interface clients expect. An adapter lets classes work together that could not otherwise because of incompatible interfaces. The enterprise integration pattern equivalent is the translator.

### Behavioral patterns
- Observer
    - Define a one-to-many dependency between objects where a state change in one object results in all its dependents being notified and updated automatically.