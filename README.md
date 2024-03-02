# MEASURING EXECUTION TIME OF PROCESSES IN DIFFERENT PROGRAMMING LANGUAGES
## DESCRIPTION
$~~~$ A **Desktop application**, written in **Java** (_Java Swing_), that lets the user to choose what **process-related metric** to have its execution _precisely measured_: 
- **memory-related tasks**: _static/dynamic allocation_ of memory, _accessing_ statically/dynamically-allocated _memory_;
- **thread-related tasks**: _thread creation_, _thread context switch_, _thread migration_.

&nbsp;

$~~~$ When an _option_ is _chosen_, _three microbenchmarks_, one written in **C++**, one in **Java** and one in **Python**, will be _launched_ and each of them will measure the duration of the selected event. \
$~~~$ The _results_ obtained by each execution of the used microbenchmarks will be _written in a file_ and the data contained by it will be used to **calculate the averages of the execution times** (which will _also_ be _displayed_) and also to form a **graph** with a _plot for each language_, whose
- **Y axis** will represent the _Execution Time in nanoseconds_
- **X axis** will represent the _number of the run_ of the microbenchmark _corresponding_ to a certain _programming language_.

## STRUCTURE
$~~~$ The **architecture** of the application can be divided into the following _conceptual subsystems_:
1. **Start** – contains the _Main_ method, which _launches_ the _homepage_ of the application
2. **Presentation** – contains _two sub-packages_: \
$~~~$ -> **Views** (responsible for the _Graphical User Interface_) \
$~~~$ -> **Controllers** (responsible for _controlling the views_ (windows) of the Graphical User Interface)
3. **Tests** (_conceptual_) – contains _files_ for _each_ of the three _programming languages_: \
$~~~$ -> **Testc.exe** – _C++ executable_, which contains the _C++ microbenchmarks_ for the tasks \
$~~~$ -> **Testj.class** – _Java executable_, which contains the _Java microbenchmarks_ for the tasks \
$~~~$ -> **MyThread.class** – _Java executable_, which represents the _class of the threads_ used in the _thread creation microbenchmark_ \
$~~~$ -> **SynchronizedThread.class** - _Java executable_, which represents the _class of the threads_ used in the _thread context switch microbenchmark_ \
$~~~$ -> **Testp.py** – _Python script_, which contains the _Python microbenchmarks_ for the tasks
4. **Results** - contains seven _files_, each of them _storing the results_ obtained from running the _microbenchmarks_ of each of the seven _available tasks_
