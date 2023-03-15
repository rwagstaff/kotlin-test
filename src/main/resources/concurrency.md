## Concurrency

_the art of doing things at the same time_

## What is a Thread

A thread is defined at the operating system level
A thread is a set of instructions that im writing in an application that executes in a certain way
Different threads can be executed at the same time
The JVM works with several threads, e.g. GC, JIT

## What is same time?

On a single core CPU, things cannot be executed at the same time. Though it may appear that they are.
Only on a multicore CPU are thing actually happening at the same time.

## Who is responsible for the CPU sharing

The thread **scheduler**

There are three reasons for the schedule to pause a thread

- The CPU should be shared equally among threads
- A thread might be awaiting some data (reading or writing a disk)
- A thread might be waiting for another thread to do something.

## Race Condition

It means two **different** threads are trying to **read** and **write** the _same_ variable at the _same_ time

```java
class SingletonExample {

    private static SingletonExample singleObject;

    private SingletonExample() {
    }

    public static SingletonExample getInstance() {
        if (singleObject == null) {
            return new SingletonExample();
        }
    }
}
```

| Thread (T1)                       | Thread (T2)                       |
|-----------------------------------|-----------------------------------|
| Checks if instance is null?       | Waiting                           |
| The answer is yes                 |                                   |
| Enters the if block               |                                   |
| **The thread schedule pauses T1** |                                   |
|                                   | Checks if instance is null?       |
|                                   | The answer is yes                 |
|                                   | Enters the if block               |
|                                   | Creates an instance of Singleton  |
|                                   | **The thread schedule pauses T2** |
|                                   | **The thread schedule pauses T2** |
| Creates an instance of Singleton  |                                   |

This is a well known race condition, two instances of Singleton are created

## How to prevent that?

The answer is _syncronization_

This prevents a block of code to be executed by more than one thread at the same time. 
It prevents the thread scheduler give the hand to another thread while within a synchronized block of code.

## How does synchronization work

When I thread enters a syncronised block of code. It will ask the object for a key from the lock object. All objects have this lock object.

If the key is available the thread will take the object key.
Once the thread has finished executing the synchronized block it will give the lock back to the object.



```java
/**
 * In the Singleton example, the key is the Singleton class itself
 */
class SingletonExample {

    private static SingletonExample singleObject;

    private SingletonExample() {
    }

    public static synchronized SingletonExample getInstance() {
        if (singleObject == null) {
            return new SingletonExample();
        }
    }
}
```

```java
/**
 * Here the key is the instance of the class
 */
class Person {
    private String name;
    private Integer age;

    public synchronized String getName() {
        return name;
    }

    /**
     * If two method have the synchronized key there is still only one lock object per instance
     */
    public synchronized Integer getAge() {
        return age;
    }
    
    
}
```

```java
/**
 * Third option, is to use a dedicated object 
 */
class Person {
    private final Object key = new Object();
    
    public String init() {
        synchronized (key) {
            
        }
    }
}
```

## Deadlocks

A deadlock is a situation where a thread T1 holds a key needed by a thread T2. 
And the thread T2 holds the key needed by T1

## 
