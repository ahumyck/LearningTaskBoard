package com.evgeniy.task.board;

import com.evgeniy.task.Task;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public interface MapTaskBoard extends CollectionTaskBoard,Cloneable,Iterable<Task>{
        MapTaskBoard clone() throws CloneNotSupportedException;
}
