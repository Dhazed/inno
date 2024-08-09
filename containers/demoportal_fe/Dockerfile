FROM integrazione.mgmt.infocert.it/docker-remote/nginx:1.21.1-alpine

RUN mkdir -p /usr/share/nginx/html/

COPY dist/demoportal_fe/browser /usr/share/nginx/html/demoportal
# Expose port 80
EXPOSE 80
