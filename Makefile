# makkefile begins
# define a variable for compiler flags (JFLAGS)
# define a variable for the compiler (JC)  
# define a variable for the Java Virtual Machine (JVM)
# define a variable for a parameter. When you run make, you could use:
# make run FILE="Algo.csv" para sobre escribir el valor de FILE. 

JFLAGS = -g
JC = javac
JVM= java 
FILE=

#
# Clear any default targets for building .class files from .java files; we 
# will provide our own target entry to do this in this makefile.
# make has a set of default targets for different suffixes (like .c.o) 
# Currently, clearing the default for .java.class is not necessary since 
# make does not have a definition for this target, but later versions of 
# make may, so it doesn't hurt to make sure that we clear any default 
# definitions for these
#

.SUFFIXES: .java .class

#
# Here is our target entry for creating .class files from .java files 
# This is a target entry that uses the suffix rule syntax:
#	DSTS:
#		rule
# DSTS (Dependency Suffix     Target Suffix)
# 'TS' is the suffix of the target file, 'DS' is the suffix of the dependency 
#  file, and 'rule'  is the rule for building a target	
# '$*' is a built-in macro that gets the basename of the current target 
# Remember that there must be a < tab > before the command line ('rule') 
#

.java.class:
	$(JC) $(JFLAGS) $*.java

#
# CLASSES is a macro consisting of N words (one for each java source file)
# When a single line is too long, use \<return> to split lines that then will be
# considered as a single line. For example:
# NAME = Camilo \
^IJuan 
# is understood as
# NAME = Camilo        Juan

CLASSES = \
	store/LessThanZeroQuantityException.java\
	store/Item.java\
	store/ItemContainer.java\
	store/Cart.java\
	store/Store.java\
	account/Account.java\
	account/User.java\
	account/Admin.java\
	account/AccountCreator.java\
	account/AccountManager.java\
	account/AccountManagerImpl.java\
	remote/OnlineStore.java\
	client/Client.java 

#
# the default make target entry
# for this example it is the target classes

default: classes

# Next line is a target dependency line
# This target entry uses Suffix Replacement within a macro: 
# $(macroname:string1=string2)
# In the words in the macro named 'macroname' replace 'string1' with 'string2'
# Below we are replacing the suffix .java of all words in the macro CLASSES 
# with the .class suffix
#

classes: $(CLASSES:.java=.class)

# this line is to remove all unneeded files from
# the directory when we are finished executing(saves space)
# and "cleans up" the directory of unneeded .class files
# RM is a predefined macro in make (RM = rm -f)
#

clean:
	$(RM) store/LessThanZeroQuantityException.class
	$(RM) store/Item.class
	$(RM) store/ItemContainer.class
	$(RM) store/Store.class
	$(RM) store/Cart.class
	$(RM) account/Account.class
	$(RM) account/User.class
	$(RM) account/Admin.class
	$(RM) account/AccountCreator.class
	$(RM) account/AccountManager.class
	$(RM) account/AccountManagerImpl.class
	$(RM) remote/OnlineStore.class
	$(RM) client/Client.class