package com.evgeniy.task.board;

import com.evgeniy.task.Task;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface ListTaskBoard extends CollectionTaskBoard,Cloneable,Iterable<Task>{
   ListTaskBoard clone() throws CloneNotSupportedException;

}
