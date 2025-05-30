TARGET=lab6

SRC=${TARGET}.tex

IMGPATH=../img
SVGS=$(wildcard ${IMGPATH}/*.svg)

PDFTEX=pdflatex

BIB=bibtex

.PHONY=pdftex pdfbib clean cleanimg

pdftex: prepimg
	${PDFTEX} ${SRC}
	${PDFTEX} ${SRC}

pdfbib: prepimg
	${PDFTEX} ${SRC}
	${BIB} ${TARGET}.aux
	${PDFTEX} ${SRC}
	${PDFTEX} ${SRC}

prepimg: $(SVGS:%.svg=%.pdf)

%.pdf: %.svg
	inkscape --export-filename=$@ $<

clean:
	@echo "Cleaning auxiliary files..."
	rm *.aux *.bbl *.blg *.log *.nav *.out *.snm *.pdf *.synctex.gz *.toc *.vrb
	@echo "Done."

cleanimg:
	rm ${IMGPATH}/*.pdf

