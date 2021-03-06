package com.bph5nai.gossip.util

import androidx.work.Constraints
import androidx.work.NetworkType

val postDataConstraints = Constraints.Builder()
    .setRequiresBatteryNotLow(true)
    .setRequiredNetworkType(NetworkType.CONNECTED)
    .build()