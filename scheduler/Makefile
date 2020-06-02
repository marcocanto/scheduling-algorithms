# Add your scheduling algorithms here!
SCHEDULING_ALGORITHMS = \
	RandomSchedulingAlgorithm.java\
	FCFSSchedulingAlgorithm.java\
	SJFSchedulingAlgorithm.java\
	RoundRobinSchedulingAlgorithm.java

# Build up SOURCES to include all java files in the package directory
PACKAGE_DIR = src
RAW_SOURCES = \
	Process.java\
	SchedulingAlgorithm.java\
	BaseSchedulingAlgorithm.java\
	OptionallyPreemptiveSchedulingAlgorithm.java\
	BetterFileFilter.java\
	CPUScheduler.java\
	MainFileLoader.java
RAW_SOURCES += $(SCHEDULING_ALGORITHMS)
SOURCES = $(foreach s, $(RAW_SOURCES), $(PACKAGE_DIR)/$(s))
# PICS_DIR = pics
BIN_DIR = bin
CLASSPATH = $(BIN_DIR):.

.PHONY: all jarfile submission

all: classes jarfile

classes: $(SOURCES) Makefile
# We need to tell Java compiler where to put the package hierarchy (current directory)
	mkdir -p $(BIN_DIR)
	javac -g -cp $(CLASSPATH) $(SOURCES) -d $(BIN_DIR)

jarfile: classes
	rm -f CPUSchedulingSimulator.jar
	jar -cvfm CPUSchedulingSimulator.jar src/manifest.mf -C $(BIN_DIR) .

clean:
	rm -rf $(BIN_DIR)
	rm -f *.jar
	rm -rf submission
	rm -f submission.zip

run:
	java -cp $(CLASSPATH) MainFileLoader

submission:
	rm -rf submission
	rm -f submission.zip
	mkdir -p submission
	cp -r src submission
	cp Makefile simu.sh submission
	zip -r submission.zip submission
