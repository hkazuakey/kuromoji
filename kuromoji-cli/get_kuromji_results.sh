#!/bin/bash

OUTDIR=results_kuromoji

rm -rf ${OUTDIR}
mkdir -p ${OUTDIR}

CMD="java -jar target/kuromoji-cli-jar-with-dependencies.jar"

outcount=0
while IFS='' read -r line || [[ -n "$line" ]]; do
    ${CMD} "${line}" > ${OUTDIR}/results_${outcount}.mecab
    outcount=$((++outcount))
done < "$1"
