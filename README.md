# College Schedule

This software is planned to facilitate Distance Learning. It allows to create schedules for group lessons.

Since distance learning does not have any Classrooms involved, there are no Classrooms or Building Addresses.

Now this repository contains only a UML diagram of the Model for the future project.

The Model contains such entities as Students, Professors, Groups, Lessons, Day Schedules and Year Schedules.

Year Schedules contain Day Schedules, and Day Schedules contain Lessons. 

Schedules can be checked for inconsistencies, or overlaps. 

Every Day Schedule can check itself for time overlaps in lessons. If the same professor or the same group has a lesson starting before another lesson finishes registered with the same professor or group, a list of such lessons is returned as the result of a method called checkOverlaps. 

If the check has found some overlaps, then the hasOverlaps boolean field is set to true. Then, the method checkOverlapDays in the Year Schedule class returns a list of IDs for days where the hasOverlaps field is set to true. This way all the available inconsistencies can be found.

