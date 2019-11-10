package com.example.demo.coreapi

import org.axonframework.modelling.command.TargetAggregateIdentifier

data class CreateCommand(@TargetAggregateIdentifier val id:String,val amount:Int)
data class RedeemCommand(@TargetAggregateIdentifier val id:String,val amount:Int)

data class CreateEvent(val id:String,val amount:Int)
data class RedeemEvent(val id:String,val amount:Int)
class AllcardsQuery

data class CardAmountQuery(val id:String)
