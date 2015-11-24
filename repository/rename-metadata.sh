#!/bin/bash
#
#mvn install -DperformRelease=true -DcreateChecksum=true

metadata="$1"
metadata_local="$1"

#remove old sum
rm -f "$metadata_local.md5"
rm -f "$metadata_local.sha1"

empty=""
metadata="${metadata/-local.xml/$empty}".xml

#create new sum
mv "$metadata_local" "$metadata"
md5sum "$metadata" > "$metadata".md5
sha1sum "$metadata" > "$metadata".sha1
