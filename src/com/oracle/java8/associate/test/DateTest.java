/*
 * Copyright (c) 2018, fscotto
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR Alpha PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.oracle.java8.associate.test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 *
 * @author fscotto
 */
public class DateTest {

    public static void main(String[] args) {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.parse("2018-02-12"));
        dates.add(LocalDate.of(2014, 4, 10));
        
        dates.removeIf(d -> d.getYear() < 2000);
        
        System.out.println(dates);
        
        //LocalDate.of(2001, Month.FEBRUARY, 29);
        
        //LocalDate.parse("2018-09-31");
        
        List<LocalTime> times = new ArrayList<>();
        times.add(LocalTime.of(16, 40));

        Date java7Date = new Date();

        LocalDate localDate = java7Date.toInstant()
                                       .atZone(ZoneId.systemDefault())
                                       .toLocalDate();

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        ZonedDateTime zdt = yesterday.atStartOfDay(ZoneId.systemDefault());
        System.out.println(LocalDateTime.of(yesterday, LocalTime.MAX));

        LocalDate ld = LocalDate.of(2018, Month.JULY, 1);
        LocalDateTime endDate = getEndDate(ld);
        System.out.println(endDate);

        System.out.println(LocalDateTime.MAX);

        LocalDateTime infinity = LocalDateTime.of(9999, Month.DECEMBER, 31, 23, 59, 59);
        System.out.println(infinity);

        LocalDate myBirthday = LocalDate.of(1988, Month.FEBRUARY, 17);

        System.out.println(myBirthday.get(ChronoField.YEAR));
        System.out.println(LocalDate.now());
        Period period = Period.between(myBirthday, LocalDate.now());
        System.out.println(period.getYears());
    }

    public static LocalDateTime getEndDate(LocalDate date) {
        return LocalDateTime.of(date.minusDays(1), LocalTime.MAX);
    }
}
