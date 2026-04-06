JAVAC = javac
JAVA  = java

SRC_DIR = project
MAIN = project.Main

SOURCES = $(shell find $(SRC_DIR) -name "*.java")
CLASSES = $(SOURCES:.java=.class)

.PHONY: all run clean docs


all:
	$(JAVAC) -d . $(SOURCES)


run: all
	$(JAVA) -cp . $(MAIN)

# cleans up files
clean:
	rm -f $(CLASSES)

# makes doxygen
docs:
	doxygen Doxyfile

# save progress, git commands
save:
	git add .