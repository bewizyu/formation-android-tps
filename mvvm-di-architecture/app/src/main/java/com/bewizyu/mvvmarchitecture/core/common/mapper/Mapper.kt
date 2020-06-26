package com.bewizyu.mvvmarchitecture.core.common.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}