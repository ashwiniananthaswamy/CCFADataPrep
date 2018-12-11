package com.ccfa.test.common;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.SdkClientException;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class awshelper {

	public void ListS3Object() {
		final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
		ListObjectsV2Result result = s3.listObjectsV2("emrccfa");
		List<S3ObjectSummary> objects = result.getObjectSummaries();
		for (S3ObjectSummary os : objects) {
			System.out.println("******Getting Object for " + os.getKey());
			try {
				System.out.println("Downloading an object");
				S3Object fullObject = s3.getObject("emrccfa", os.getKey());
				System.out.println("Content-Type: " + fullObject.getObjectMetadata().getContentType());
				System.out.println("Content: ");
				displayTextInputStream(fullObject.getObjectContent());
			} catch (AmazonServiceException e) {
				System.err.println(e.getErrorMessage());
				System.exit(1);
			} catch (SdkClientException e) {
				// Amazon S3 couldn't be contacted for a response, or the client
				// couldn't parse the response from Amazon S3.
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Done Getting object!");
		}
	}

	private void displayTextInputStream(InputStream input) throws IOException {
		// Read the text input stream one line at a time and display each line.
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println();
	}
}
